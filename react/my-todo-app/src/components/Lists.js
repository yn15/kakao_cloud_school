import React from 'react'
import { DragDropContext, Draggable, Droppable } from 'react-beautiful-dnd';

// 구조분해할당
export default function Lists({todoData, setTodoData}) {

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
            <DragDropContext>
                <Droppable droppableId='to-do'>
                    {(provided) => (
                        <div {...provided.droppableProps} ref={provided.innerRef}>
                            {todoData.map((data, index) => (
                                <Draggable 
                                    key={data.id} 
                                    draggableId={data.id.toString()} 
                                    index={index}>
                                    {(provided, snapshot) => (
                                        <div key={data.id} 
                                            {...provided.draggableProps} 
                                            ref={provided.innerRef}
                                            {...provided.dragHandleProps}>
                                            <div className={`${snapshot.isDragging? " bg-gray-500 " : " bg-gray-100 "}flex items-center justify-between w-full px-4 py-1 my-2 text-gray-600 border rounded`}>
                                                <div className='items-center'>
                                                    <input type="checkbox"
                                                        defaultChecked={false}
                                                        onChange={() => handleCompleteChange(data.id)} />
                                                    {" "}<span className={data.completed ? "line-through" : undefined}>{data.title}</span>
                                                </div>
                                                <div className='items-center'>
                                                    <button onClick={() => deleteClick(data.id)}>delete</button>
                                                </div>
                                            </div>
                                        </div>
                                    )}
                                </Draggable>
                            ))}
                            {provided.placeholder}
                        </div>
                    )}
                </Droppable>
            </DragDropContext>
        </div>
    )
}
