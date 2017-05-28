<template>
    <div>
        <h1>Chat Head</h1>
        <input type="text" v-model="message">
        <p>{{ message }} {{ data.msg }} {{ data.num }} </p>
    </div>
</template>

<script>
    export default {
        props: ["data"],
        data() {

            return {
                message: ''
            }
        }
    }
</script>