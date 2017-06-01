<template>
    <div>
        <h1 :class="{ active: typeMessageSent }">Chat Head</h1>
        <input type="text" v-model="message" @keydown="onkeydown">
        <p>{{ message }} {{ data.msg }} {{ data.num }} </p>
        <p :class="{ messageRecieved : messageRecieved }"> {{ messageStatus }} : {{ recieved }}</p>
    </div>
</template>
s
<script>
    export default {
        props: ["data"],
        data() {
            return {
                timerRunning: false,
                searchTimeout: undefined,
                messageRecieved: false,
                message: '',
                recieved: ''
            }
        },

        computed: {
           messageStatus() {
               return this.messageRecieved ? "Message Recieved!!!" : "Message Not so recieved";
           },
            typeMessageSent() {
               return this.searchTimeout != undefined;
            }
        },

        methods: {
            onkeydown() {
                this.messageRecieved = false;

                if (this.searchTimeout != undefined) clearTimeout(this.searchTimeout);
                this.searchTimeout = setTimeout(this.stoppedTyping, 1000);

            },

            msgRecieved(responseJson) {
                console.log("Response:", responseJson)
                this.messageRecieved = true;
                this.recieved = responseJson.msg;

            },

            stoppedTyping() {
                this.searchTimeout = undefined;
                var href = window.location.href.replace("8008", "8080");

                $.ajax({
                    type: "POST",
                    url: href + "Server",
                    data: {message: this.message},
                    success: this.msgRecieved,
                    error: this.msgRecieved
                });
            }
        }
    }

</script>

<style>

    .active {
        background-color: blue;
    }

    .messageRecieved {
        background-color: red;
    }
</style>