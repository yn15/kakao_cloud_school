import React from 'react'
import { DragDropContext, Draggable, Droppable } from 'react-beautiful-dnd';
import List from './List';

const Lists = React.memo(({deleteClick, todoData, setTodoData}) => {
    console.log("Lists component 실행!");
    

    const handleDrop = (e) => {
        // e: event 객체, event에 대한 세부정보
        // e.source: drag한 객체
        // e.destination: drop한 객체
        if(!e.destination) return;

        const newTodoData = todoData;

        // Drag된 요소를 삭제
        const [reorder] = newTodoData.splice(e.source.index, 1);

        // Drop되는 위치에 삽입
        newTodoData.splice(e.destination.index, 0, reorder);

        setTodoData(newTodoData);
    }

    return (
        <div>
            <DragDropContext onDragEnd={handleDrop}>
                <Droppable droppableId='to-do'>
                    {(provided) => (
                        <div {...provided.droppableProps} ref={provided.innerRef}>
                            {todoData.map((data, index) => (
                                <Draggable 
                                    key={data.id} 
                                    draggableId={data.id.toString()} 
                                    index={index}>
                                    {(provided, snapshot) => (
                                        // component 위치해야함
                                        <List 
                                        deleteClick={deleteClick}
                                        id={data.id}
                                        title={data.title}
                                        completed={data.completed}
                                        todoData={todoData}
                                        setTodoData={setTodoData}
                                        provided={provided}
                                        snapshot={snapshot}/>
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
});

export default Lists;
