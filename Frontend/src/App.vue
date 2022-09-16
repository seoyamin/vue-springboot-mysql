<template>
  <div id="app">
    <div class="top">
      <TodoHeader />
      <div v-if="this.storedName">
        <TodoTitle />
        <TodoInput v-on:alertModal="showModal" @reload="reload" />
      </div>

      <div v-else>
        <TodoHello />
      </div>
    </div>

    <div class="body">
      <div v-if="this.storedName">
        <TodoController />
        <TodoList ref="list" />
      </div>

      <TodoFooter />
    </div>

    <TodoModal v-show="modalVisible" v-on:close="modalVisible = false">
      <template v-slot:modal-text>{{ modalText }}</template>
    </TodoModal>


  </div>
</template>

<script>
import TodoHeader from "./components/TodoHeader"
import TodoTitle from "./components/TodoTitle"
import TodoInput from "./components/TodoInput"
import TodoController from "./components/TodoController"
import TodoList from "./components/TodoList"
import TodoFooter from "./components/TodoFooter"
import TodoModal from "@/components/common/TodoModal";
import TodoHello from "@/components/TodoHello";
import { mapGetters } from 'vuex'

export default {
  name: 'App',

  data() {
    return {
      modalVisible: false,
      modalText: ""
    }
  },

  mounted() {
    console.log(this.storedName)
  },

  computed: {
    ...mapGetters(["storedName"])
  },

  methods: {
    showModal(text) {
      this.modalText = text
      this.modalVisible = !this.modalVisible
    },

    reload() {
      this.$refs.list.getBoardList();
    }
  },

  components: {
    TodoHeader,
    TodoTitle,
    TodoInput,
    TodoController,
    TodoList,
    TodoFooter,
    TodoHello,
    TodoModal,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
