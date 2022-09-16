const storedTodoItems = (state) => {                   // state에 있는 todoItems를 가져온다
    return state.todoItems
}

const storedName = (state) => {                        // state에 있는 userName을 가져온다
    return state.userName
}

const storedTodoItemsCount = (state, getters) => {     // state에 있는 todoItems 총 개수를 가져온다
    return getters.storedTodoItems.length;
}


export { storedTodoItems, storedName, storedTodoItemsCount }