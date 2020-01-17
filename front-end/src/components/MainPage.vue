<template>
    <div class="main">
        <div class="container">
            <h3>All Conferences:</h3>
            <div class="container">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Location</th>
                        <th>Date & time</th>
                        <th>Maximum seats number</th>
                        <th>Status</th>
                    </tr>
                    </thead>
                    <tbody v-for="conference in conferenceList">
                    <tr>
                        <td>{{conference.name}}</td>
                        <td>{{conference.location}}</td>
                        <td>{{conference.date}}</td>
                        <td>{{conference.max_seats}}</td>
                        <td>{{conference.status}}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</template>

<script>
    import axios from 'axios';
    import apiRequests from './../javascript/apiRequests.js';
    export default {
        name: 'MainPage',
        components: {

        },
        data() {
            return {
                conferenceList: []
            };
        },
        methods: {
            getConferences() {

                apiRequests.getRequestToApi('/conferences')
                    .then((result => {
                            this.conferenceList = result.data;
                        })
                    ).catch(function (error) {
                    if (error.response) {
                        console.log(error.response.headers);
                    } else if (error.request) {
                        console.log(error.request);
                    } else {
                        console.log(error.message);
                    }
                    console.log(error.config);
                });
            },

        },
        mounted() {
            this.getConferences();
        }



    }
</script>

<style scoped>

</style>
