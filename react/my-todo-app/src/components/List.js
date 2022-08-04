import React, { useState } from 'react'
import Edit from './Edit';
const List = React.memo(({ index, deleteClick, id, title, completed, todoData, setTodoData, provided, snapshot}) => {
    console.log("List component 실행!");
    
    const [editFlag, setEditFlag] = useState(false);
    
    const handleCompleteChange = (id) => {
        // id에 대해 todoData의 상태 값을 변경시켜야 함
        let newTodoData = todoData.map((data) => {
            if (data.id === id) {
                data.completed = !data.completed
            }
            return data;
        })

        setTodoData(newTodoData)
    }

    const handleFlag = () => {
        setEditFlag(!editFlag);
    }

    if (!editFlag) {
        return (
            <div key={id}
                {...provided.draggableProps}
                ref={provided.innerRef}
                {...provided.dragHandleProps}
            >
                <div className={`${snapshot.isDragging ? "bg-gray-500" : "bg-gray-100"} flex items-center justify-between w-full px-4 py-1 my-2 text-gray-600 border rounded`}>
                    <div className='items-center'>
                        <input type="checkbox"
                            defaultChecked={false}
                            onChange={() => handleCompleteChange(id)} />
                        {" "}<span className={completed ? "line-through" : undefined}>{title}</span>
                    </div>

                    <div className="grid grid-cols-2 gap-4 place-items-center">
                        <div><button onClick={() => handleFlag()}>edit</button></div>
                        <div><button onClick={() => deleteClick(id)}>delete</button></div>
                    </div>
                </div>
            </div>

        )
    } if (editFlag) {
        return (
            <Edit 
            index = {index}
            title={title}
            todoData={todoData}
            setTodoData={setTodoData}
            handleFlag={handleFlag}
            />
        )
    }
});

export default List;
