import React, { useState } from 'react'
import "./App.css";

// render() method 존재하지 않음
// 함수의 return 값이 JSX
export default function App() {

  const [todoData, setTodoData] = useState([
    {
      id: "1",
      title: "운동하기",
      completed: false
    }
  ]);

  const [value, setValue] = useState("");

  const btnStyle = {
    color: "red",
    border: "none",
    padding: "5px 9px",
    borderRadius: "50%",
    float: "right",
  }

  const getStyle = (completed) => {
    return {
      padding: "20px",
      borderBottom: "1px #eee dotted",
      textDecoration: completed? "line-through" :"none"
    }
  }

  const deleteClick = (id) => {
    console.log(id);
    const newTodoData = todoData.filter(data => data.id != id);
    setTodoData(newTodoData);
  }

  const handleChange = (e) => {
    setValue(e.target.value);
  }

  const handleSubmit = (e) => {
    e.preventDefault();
    let newTodo = {
      id: Date.now(),
      title: value,
      completed: false
    };

    setTodoData([...todoData, newTodo]);
    setValue("");
  }

  const handleCompleteChange = (id) => {
    let newTodoData = todoData.map((data) => {
      if(data.id === id) {
        data.completed = !data.completed;
      }
      return data;
    })
    setTodoData(newTodoData);
  }

  return (
    <div className="container">
      <div className="todoBlock">
        <div>
          <h1>오늘의 할 일</h1>
        </div>

        {todoData.map(data => (
            <div style={getStyle(data.completed)} key={data.id}>
            <input type="checkbox" defaultChecked={false} 
                   onChange={() => {handleCompleteChange(data.id)}}/>
            {data.title}
            <button style={btnStyle}
                    onClick={()=>deleteClick(data.id)}>delete</button>
            </div>
        ))}

        <form style={{display: 'flex'}} onSubmit={handleSubmit}>
          <input type="text" 
                 name="todoInput" 
                 style={{flex: '10', padding: '5px'}} 
                 placeholder="새로운 할일을 입력하세요!" 
                 value={value}
                 onChange={handleChange}/>
          <input type="submit" 
                 value="입력"
                 className='btn'
                 style={{flex: '1'}}
                 />
        </form>
      </div>
    </div> 
  )
}

