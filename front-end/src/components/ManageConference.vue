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
                    <tbody v-for="conference in conference_list">
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
    import Home from "../views/Home";
    import apiRequests from './../javascript/apiRequests.js';

    export default {
        name: 'ManageConference',
        components: {Home},

        data() {
            return {
                conference_list: [],
                message : null
            };
        },
        methods: {
            getConferences() {
                apiRequests.getRequestToApi('/conferences')
                    .then((result => {
                            this.conference_list = result.data;
                        })
                    ).catch(() => {
                    this.message = "No conferences found";
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
                apiRequests.deleteRequestToApi('/deleteAllParticipation', id)
                    .then(() => {
                        console.log("success");
                    }).catch(() => {
                        console.log("error");
                });

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
