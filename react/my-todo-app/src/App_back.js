import React, { Component } from "react";
import "./App.css";

// class형 component
export default class App extends Component{

  constructor(props){
    super(props);
    this.state = {
      todoData : [
        {
          id: "1",
          title: "운동하기",
          completed: false
        }
      ],
      value: ""
    }
  }

  btnStyle = {
    color: "red",
    border: "none",
    padding: "5px 9px",
    borderRadius: "50%",
    float: "right",
  }

  getStyle = (completed) => {
    return {
      padding: "20px",
      borderBottom: "1px #eee dotted",
      textDecoration: completed? "line-through" :"none"
    }
  }


  deleteClick = (id) => {
    console.log(id);
    // 해당 아이디에 대한 할일 목록을 지워야함
    // 데이터를 지워요 => 배열처리로 가능
    const newTodoData = this.state.todoData.filter(data => data.id != id);
    // 변경된 데이터를 가지고 화면을 다시 그려야 해요
    // 어떻게 하면 이 작업을 수행할 수 있나요?
    // React State
    // React에서 데이터가 변할 때 화면을 다시 rendering해주기 위해 사용
    // State는 component안에서 관리됨
    // 일반적으로 생성자 안에서 정의함
    // 이름이 state라는 property
    this.setState({todoData: newTodoData});
  }

  handleChange = (e) => {
    // console.log(e.target.value);
    this.setState({value: e.target.value})
  }

  handleSubmit = (e) => {
    // 현재 submit event가 발생해서 처리
    // default event처리 안하게 하기
    e.preventDefault();
    let newTodo = {
      id: Date.now(), // unique한 값을 표현하기 위해
      title: this.state.value,
      completed: false
    };

    this.setState({todoData: [...this.state.todoData, newTodo], value: ""})
  }

  handleCompleteChange = (id) => {
    // id에 대해 todoData의 completed상태값을 변경시켜야함
    let newTodoData = this.state.todoData.map((data) => {
      if(data.id === id) {
        data.completed = !data.completed;
      }
      return data;
    })

    this.setState({todoData: newTodoData});
  }
  
  render() {
    return (
      <div className="container">
        <div className="todoBlock">
          <div>
            <h1>오늘의 할 일</h1>
          </div>

          {this.state.todoData.map(data => (
              <div style={this.getStyle(data.completed)} key={data.id}>
              <input type="checkbox" defaultChecked={false} onChange={() => {this.handleCompleteChange(data.id)}}/>
              {data.title}
              <button style={this.btnStyle}
                      onClick={()=>this.deleteClick(data.id)}>delete</button>
              </div>
          ))}

          <form style={{display: 'flex'}} onSubmit={this.handleSubmit}>
            <input type="text" 
                   name="todoInput" 
                   style={{flex: '10', padding: '5px'}} 
                   placeholder="새로운 할일을 입력하세요!" 
                   value={this.state.value}
                   onChange={this.handleChange}/>
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
}
