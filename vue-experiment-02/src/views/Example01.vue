<template>
  <div>
    用户名：{{ user.name }}
    <br />
    <p v-if="user.role == 3">管理员可见</p>
    <br />
    <table>
      <thead>
        <tr>
          <th>#</th>
          <th>name</th>
          <th>inserttime</th>
        </tr>
      </thead>
      <tr v-for="(c, index) in courses" v-bind:key="index">
        <td>{{ index + 1 }}</td>
        <td>{{ c.name }}</td>
        <td>{{ format(c.insertTime) }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  data: () => ({
    user: { name: "BO", role: "3" },
    courses: [
      { id: 4, name: "Java", insertTime: "2019-03-05T20:20" },
      { id: 5, name: "Web开发技术", insertTime: "2019-04-17T08:00" },
      { id: 6, name: "系统程序设计", insertTime: "2019-05-05T12:40" }
    ]
  }),
  computed: {
    format() {
      return data => data.replace("T", " ");
    }
  }
};
</script>
