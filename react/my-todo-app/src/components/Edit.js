import React, { useState } from 'react'

export default function Edit({ index, title, todoData, setTodoData, handleFlag,}) {
    const [editValue, setEditValue] = useState(title);
    
    const saveClick = () => {
        const newTodoData = [...todoData];

        // Drag된 요소를 삭제
        const [reorder] = newTodoData.splice(index, 1);
        reorder['title'] = editValue;
        newTodoData.splice(index, 0, reorder);

        setTodoData(newTodoData);

        handleFlag();
    }

    const handleChange = (e) => {
        setEditValue(e.target.value);
    }


    return (
        <div className={'bg-gray-100 flex pt-3 flex items-center justify-between w-full px-4 py-1 my-2 text-gray-600 border rounded'}>

                <div className='items-center'>
                    {" "}<input className='w-full px-3 py-2 mr-4 text-gray-500 border rounded shadow'
                        defaultValue={title}
                        onChange={handleChange}></input>
                </div>

                <div className="grid grid-cols-2 gap-4 place-items-center">
                    <div><button onClick={() => saveClick()} 
                                 className='p-2 text-blue-400 border-blue-400 rounded hover:text-white hover:bg-blue-200'>
                                    save</button></div>
                    <div><button onClick={() => handleFlag()}
                                className='p-2 text-blue-400 border-blue-400 rounded hover:text-white hover:bg-blue-200'>
                        back</button></div>
                </div>

        </div>
    )
}
