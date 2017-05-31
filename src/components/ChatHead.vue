<template>
    <div>
        <h1 :class="{ active: typeMessageSent }">Chat Head</h1>
        <input type="text" v-model="message" @keydown="onkeydown">
        <p>{{ message }} {{ data.msg }} {{ data.num }} </p>
    </div>
</template>

<script>
    export default {
        props: ["data"],
        data() {
            return {
                typeMessageSent: false,
                timerRunning: false,
                searchTimeout: undefined,
                message: ''
            }
        },

        methods: {
            onkeydown() {
                this.typeMessageSent = true;

                if (this.searchTimeout != undefined) clearTimeout(this.searchTimeout);
                this.searchTimeout = setTimeout(this.onkeyup, 1000);

            },

            onkeyup() {
                this.typeMessageSent = false;
            }
        }
    }

</script>

<style>

    .active {
        background-color: blue;
    }
</style>