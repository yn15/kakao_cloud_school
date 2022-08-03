import React from 'react'

// 구조분해할당
export default function Lists({todoData, setTodoData}) {
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
        <div>
            {todoData.map(data => (
                <div style={getStyle(data.completed)} key={data.id}>
                <input type="checkbox" defaultChecked={false} 
                        onChange={() => {handleCompleteChange(data.id)}}/>
                {data.title}
                <button style={btnStyle}
                        onClick={()=>deleteClick(data.id)}>delete</button>
                </div>
            ))}
        </div>
    )
}
