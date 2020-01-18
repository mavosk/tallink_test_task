<template>

    <div>
        <Home/>
        <div class="container">
            <h1>Please choose conference to cancel from active conferences:</h1>
            <div v-if="message" class="alert alert-success">
                {{message}}
            </div>
            <div class="container">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Location</th>
                        <th>Date & time</th>
                        <th>Maximum seats number</th>
                        <th>Status</th>
                        <th>Detail view</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody v-for="conference in conferenceList">
                    <tr>
                        <td>{{conference.name}}</td>
                        <td>{{conference.location}}</td>
                        <td>{{conference.date}}</td>
                        <td>{{conference.max_seats}}</td>
                        <td>{{conference.status}}</td>
                        <td>
                            <button class="btn btn-success" v-on:click="goToDetail(conference.id)"
                                    :data="conference" :key="conference.id">
                               Details
                            </button>
                        </td>
                        <td>
                            <button class="btn btn-warning" v-on:click="deleteConference(conference.id)">
                                Delete
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>

</template>

<script>
    import axios from 'axios';
    import Home from "../views/Home";
    import apiRequests from './../javascript/apiRequests.js';

    export default {
        name: 'CancelConference',
        components: {Home},

        data() {
            return {
                conferenceList: [],
                message : null
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

            deleteConference(id) {
                apiRequests.deleteRequestToApi('/deleteConference', id)
                    .then(() =>
                        {
                            this.message = `Delete of conference ${id} Successful`;
                            this.getConferences();
                        }
                    );

            },
            goToDetail(proId) {
                this.$router.push({name: 'viewConference', params: {id: proId}})
            }
        },
        watch: {
            $route() {
                this.getConferences();
            }
        },
        mounted() {
            this.getConferences();
        }
    }
</script>

<style scoped>

</style>
