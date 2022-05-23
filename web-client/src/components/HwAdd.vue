<template>
  <div class="display-board mrgnbtm">
    <h3>New Homework</h3>
    <div class="new-hw mrgnbtm">
      <input type="text" v-model="title" placeholder="Title"/>
      <textarea v-model="description" placeholder="Task Description" class="descr"> </textarea>
      <input type="date" v-model="deadline" placeholder="deadline" />
    </div>
    <div class="btn">
      <button @click='addHomework()' type="button" class="btn btn-warning">Add homework</button>
    </div>
  </div>
</template>

<script>
import {addHomework} from "@/services/HwService";
//import moment from 'moment'

export default {
  name: "HwAdd",

  data() {
    return {
      title: '',
      description: '',
      deadline: ''
    }
  },

  methods: {
    addHomework() {
      const hw = {
        title: this.title,
        taskDescription: this.description,
        publicationTime: new Date().toISOString(), //moment(new Date()).format('YYYY-DD-MMTHH:MM:SS'),
        //publishedAt: new Date().toISOString().replace(RegExp("\\d{2}:\\d{2}:\\d{2}.\\d{3}Z$"), "00:00:00.000Z"),
        deadline: new Date(this.deadline).toISOString()
      }

      addHomework(hw).then(response => {
        console.log(response);
      })

    }
  }
}
</script>