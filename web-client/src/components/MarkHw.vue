<template>
  <div class="display-board mrgnbtm">
    <h3>Evaluate Homework</h3>
    <div class="eval mrgnbtm">
      <input type="number" v-model="submissionId" placeholder="submission id" class="id-input"/>
      <input type="number" v-model="mark" placeholder="mark" class="id-input"/>
      <textarea v-model="comment" placeholder="Comment" class="descr"> </textarea>
    </div>
    <div class="btn mrgnbtm">
      <button @click='evalSubmission()' type="button" class="btn btn-warning">Add homework</button>
    </div>
  </div>

</template>

<script>
import {evaluateSubmission} from "@/services/HwService";

export default {
  name: "MarkHw",

  data() {
    return {
      submissionId: '',
      mark: '',
      comment: ''
    }
  },

  methods: {
    evalSubmission() {
      evaluateSubmission(this.mark, this.comment, this.submissionId)
    }
  }
}
</script>