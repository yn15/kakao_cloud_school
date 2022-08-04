import React from 'react'

export default function Form({todoData, setTodoData, value, setValue}) {
    console.log("Form component 실행!");
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
        <form onSubmit={handleSubmit} className="flex pt-2">
            <input type="text"
                   name='todoItem'
                   placeholder='새로운 할일을 입력하세요'
                   className='w-full px-3 py-2 mr-4 text-gray-500 border rounded shadow'
                   value={value}
                   onChange={handleChange}
            />
            <input type='submit'
                   value='입력'
                   className='p-2 text-blue-400 border-blue-400 rounded hover:text-white hover:bg-blue-200'
            />
        </form>
    
    )
}
