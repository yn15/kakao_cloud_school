import React from 'react'

export default function Form({todoData, setTodoData, value, setValue}) {

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

    return (
        <div>
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
    )
}
