<template>
  <div class="add">
    <div class="main-input">
      <input
          type="text"
          class="add__input"
          placeholder="Enter your task here"
          v-model="newTodoItem"
          v-on:keypress.enter="addTodoItem"
          ref="taskInput"
      />
      <button class="add__button" v-on:click="addTodoItem">
        <span class="blind">Add</span>
      </button>
    </div>
  </div>
</template>

<script>
import {mapGetters} from "vuex";
export default {
  data() {
    return {
      newTodoItem: ""
    }
  },

  computed: {
    ...mapGetters(["storedTodoItems", "storedTodoItemsCount"])
  },

  methods: {
    addTodoItem() {
      // 중복된 내용인 경우
      const oldItems = this.storedTodoItems
      for(let i=0 ; i<this.storedTodoItemsCount ; i++) {
        if(oldItems[i].item === this.newTodoItem) {
          const text = "이미 존재하는 할일입니다."
          this.$emit("alertModal", text)
          return false
        }
      }

      // 빈 내용인 경우
      if(this.newTodoItem === "") {
        const text = "입력된 내용이 없습니다. 할일을 입력해주세요."
        this.$emit("alertModal", text)
        this.clearInput()
        return false
      }

      this.$store.commit("addOneItem", this.newTodoItem)
      this.clearInput()
      this.$refs.taskInput.focus()
    },

    clearInput() {
      this.newTodoItem = ""
    }
  }
}

</script>


<style>
.add {
  padding: 50px;
}
.add__input {
  width: 350px;
  height: 30px;
  padding-left: 10px;
}
.add__button {
  width: 55px;
  height: 36px;
  cursor: pointer;
}
</style>