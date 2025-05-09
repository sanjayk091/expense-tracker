const api = '/api/expenses';

function addExpense() {
  const data = {
    description: document.getElementById('desc').value,
    category: document.getElementById('category').value,
    amount: parseFloat(document.getElementById('amount').value),
    date: document.getElementById('date').value
  };

  fetch(api, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(data)
  })
  .then(() => {
    getAll();
    clearForm();
  });
}

function clearForm() {
  ['desc', 'category', 'amount', 'date'].forEach(id => document.getElementById(id).value = '');
}

function getAll() {
  fetch(`${api}/list`)
    .then(res => res.json())
    .then(data => {
      const tbody = document.getElementById('expenses').querySelector('tbody');
      tbody.innerHTML = '';
      data.forEach(e => {
        tbody.innerHTML += `
          <tr>
            <td>${e.id}</td><td>${e.category}</td><td>₹ ${e.amount}</td><td>${e.description}</td><td>${e.date}</td>
            <td><button onclick="deleteExpense(${e.id})">Delete</button></td>
          </tr>`;
      });
    });
}

function getByCategory() {
  const category = document.getElementById('filterCat').value.trim();
  const resultDiv = document.getElementById('catResult');
  resultDiv.innerHTML = '';

  if (!category) {
    resultDiv.innerHTML = '<p>Please enter a category.</p>';
    return;
  }

  fetch(`${api}/category/${encodeURIComponent(category)}`)
    .then(res => {
      if (!res.ok) throw new Error('Failed to fetch data');
      return res.json();
    })
    .then(data => {
      if (data.length === 0) {
        resultDiv.innerHTML = '<p>No expenses found.</p>';
        return;
      }

      let table = `
        <table>
          <thead><tr><th>Amount</th><th>Date</th><th>Description</th></tr></thead>
          <tbody>
            ${data.map(e => `
              <tr>
                <td>₹ ${e.amount}</td>
                <td>${e.date}</td>
                <td>${e.description}</td>
              </tr>`).join('')}
          </tbody>
        </table>`;
      resultDiv.innerHTML = table;
    })
    .catch(err => {
      resultDiv.innerHTML = `<p style="color:red;">Error: ${err.message}</p>`;
    });
}

function getTotal() {
  fetch(`${api}/total/all`)
    .then(res => res.text())
    .then(total => document.getElementById('total').innerText = `₹ ${total}`);
}

function getTotalByCategory() {
  const category = document.getElementById('totalCat').value.trim();
  if (!category) return;

  fetch(`${api}/total/category/${encodeURIComponent(category)}`)
    .then(res => res.text())
    .then(total => document.getElementById('totalByCat').innerText = `₹ ${total}`);
}

function deleteExpense(id) {
  fetch(`${api}/${id}`, { method: 'DELETE' }).then(() => getAll());
}

window.onload = getAll;
