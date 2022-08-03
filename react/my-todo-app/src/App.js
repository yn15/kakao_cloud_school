import React, { useState } from 'react'
import "./App.css";
import Lists from './components/Lists';
import Form from './components/Form';

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

  



  return (
    <div className="flex items-center justify-center w-screen h-screen bg-blue-100">
        <div className="w-full p-6 m-4 bg-white rounded shadow md:w-3/4 md:max-w-lg lg:w-3/4 lg: max-w-lg">
            <div className="flex justify-between mb-3">
                <h1>오늘의 할 일</h1>
            </div>


            <Lists todoData={todoData} setTodoData={setTodoData} />

            <Form todoData={todoData} setTodoData={setTodoData} value={value} setValue={setValue} />
        </div>
    </div>
)
}

