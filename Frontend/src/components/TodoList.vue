<template>
  <transition-group name="list" tag="ul" class="list" v-bind:class="listempty">
    <li
        class="list__item"
        v-for="(todoItem, index) in this.storedTodoItems"
        v-bind:key="todoItem.item"
    >
      <input
          type="checkbox"
          v-bind:id="todoItem.item"
          v-bind:checked="todoItem.completed === true"
          v-on:change="toggleComplete({todoItem})"
      />
      <label v-bind:for="todoItem.item" class="list__label">
        <span class="icon-check"></span>
        <p class="list__text">{{ todoItem.item }}</p>
      </label>
      <div class="list__right">
        <button class="list__delete" v-on:click="removeTodo({todoItem, index})">
          <div class="blind">Delete</div>
        </button>
        <p class="list__date">{{ todoItem.date }}</p>
      </div>
    </li>
  </transition-group>
</template>


<script>
import {mapGetters, mapMutations} from "vuex";

export default {
  name: 'todoItems',

  computed: {
    ...mapGetters(["storedTodoItems", "storedTodoItemsCount"]),

    listempty() {
      return this.storedTodoItemsCount <= 0 ? "list--empty" : null
    }
  },

  methods: {
    ...mapMutations({
      removeTodo: "removeOneItem",
      toggleComplete: "toggleOneItem"
    })
  }
}

</script>


<style>
.list {
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 5px 200px 0px 200px;
  padding: 20px;
  border-radius: 20px;
  background: #f6f6f6;
}
</style>