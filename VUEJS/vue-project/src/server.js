const express = require('express');
const mysql = require('mysql2');
const cors = require('cors');

const app = express();
app.use(cors());
app.use(express.json());

const db = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'password',
  database: 'bulletin_board'
});

db.connect(err => {
  if (err) throw err;
  console.log('MySQL 연결됨');
});

app.get('/posts', (req, res) => {
  db.query('SELECT * FROM posts', (err, results) => {
    if (err) throw err;
    res.json(results);
  });
});

app.post('/posts', (req, res) => {
  const { title, content } = req.body;
  db.query('INSERT INTO posts (title, content) VALUES (?, ?)', [title, content], (err, result) => {
    if (err) throw err;
    res.json({ id: result.insertId, title, content });
  });
});

app.listen(3000, () => {
  console.log('서버 실행 중: http://localhost:3000');
});
