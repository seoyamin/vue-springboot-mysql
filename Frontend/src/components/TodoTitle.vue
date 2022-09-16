<template>
  <div class="title">
    <p class="title__text">
      <span class="title__message">Good {{ message }}, </span>
      <span
          v-on:keyup.enter="handleEnter"
          v-on:blur="handleBlur"
          class="title__name"
          ref="test"
          contenteditable="true"
      >{{ this.userName }}</span>
      .
    </p>
    <p class="title__task">
      <span class="title__task-top">오늘의 할 일은 </span>
      <span class="title__task-count">
        <em class="title__task-left">{{ this.todoItemsCount.left }}</em>
        <em
            v-if="this.todoItemsCount.total"
            class="title__task-total"
        >&nbsp;/ {{ this.todoItemsCount.total }}</em>
      </span>
      <span class="title__task-bottom">
        <span v-if="this.todoItemsCount.total > 1"></span>
        <span v-else></span> 입니다 !
      </span>
      <span class="title__task-info"></span>
    </p>
  </div>
</template>


<script>
import getDate from "@/assets/common/getDate";
export default {
  data() {
    return {
      message: "",
      userName: this.$store.getters.storedName
    }
  },

  mounted() {
    this.message = getDate().daytime
  },

  methods: {
    // 포커스 아웃 시, 입력된 이름을 userName으로 저장
    handleBlur(e) {
      const originalName = this.userName
      const newName = e.target.innerText

      if(newName != originalName) {
        if(newName=="") {
          e.target.innerText = originalName
        }

        else {
          this.$store.commit("setUserName", newName)
        }
      }
    },

    handleEnter() {
      this.$refs.test.blur()
    }
  },

  computed: {
    todoItemsCount() {
      const checkLeftItems = () => {
        const items = this.$store.getters.storedTodoItems

        let leftCount = 0
        for(let i=0 ; i<items.length ; i++) {
          if(items[i].completed === false) {
            leftCount++
          }
        }
        return leftCount
      }

      const count = {
        total: this.$store.getters.storedTodoItemsCount,
        left: checkLeftItems()
      }

      return count
    }
  },


}
</script>


<style>
.title {
  height: 120px;
  margin-left: 200px;
  margin-right: 200px;
  border: solid 1px #d0d0d0;
  border-radius: 20px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.title__message, .title__name {
  font-size: 17px;
  font-weight: lighter;
  color: #8fb691;
}
.title__task {
  margin-top: 5px;
  font-size: 25px;
  font-weight: lighter;
  color: #8fb691;
}
</style>
