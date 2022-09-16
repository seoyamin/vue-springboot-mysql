<template>
  <transition name="modal" appear>
    <div class="modal modal__dim" v-on:click.self="$emit('close')">
      <div class="modal__content">
        <p class="modal__text">
          <slot name="modal-text">(여기에 모달 내용이 들어가요)</slot>
        </p>
        <button class="modal__close" v-on:click="$emit('close')">OK</button>
      </div>
    </div>
  </transition>
</template>

<script>
export default {
};
</script>