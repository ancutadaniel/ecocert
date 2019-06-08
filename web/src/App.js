import React from 'react';
import './App.css';
import { FilePond, registerPlugin } from 'react-filepond';
import 'filepond/dist/filepond.min.css';

import FilePondPluginImagePreview from 'filepond-plugin-image-preview';
import 'filepond-plugin-image-preview/dist/filepond-plugin-image-preview.min.css';

import FilePondPluginFileValidateType from 'filepond-plugin-file-validate-type';

import "bootstrap/dist/css/bootstrap.min.css";
import { HomePage, Formular } from './pages/';
import { BrowserRouter, Route} from 'react-router-dom';
import { Container, Row, Col, Image, ListGroup, Navbar, ButtonToolbar, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { Map, Marker, GoogleApiWrapper } from 'google-maps-react';
import "bootstrap/dist/css/bootstrap.min.css";
import MainMenu from './shared/mainMenu';
import { library } from '@fortawesome/fontawesome-svg-core';
import { faCheckSquare, fas } from '@fortawesome/free-solid-svg-icons';
// import { faGoogle, fab, faFacebook } from '@fortawesome/free-brands-svg-icons';

library.add(fas, faCheckSquare);

registerPlugin(FilePondPluginImagePreview, FilePondPluginFileValidateType);


class App extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            server: {
                process: {
                    url: 'http://192.168.34.67:8081/images',
                    withCredentials: false,
                    onload: (response) => {response = JSON.parse(response); return response.imageUUID },
                },
                fetch: null,
                revert: null,
                restore: null,
                load: null
            },
            acceptedFileTypes: ['image/*'],
            required: true,
            nextDisabled: true
        };

        // This binding is necessary to make `this` work in the callback
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick(){
        console.log(this.pond.getFiles());
    }

    render() {
        return (
            <BrowserRouter>
                <Container className="App">
                <MainMenu site_name="ECOCERT"/>
                <Route exact path="/" component={ HomePage } />
                <Route exact path="/formular" component={ Formular } />   
                </Container>
            </BrowserRouter>
        );
    }
}

export default GoogleApiWrapper({
  apiKey: "AIzaSyA8IRQEYZiMYyOsk5SNapLmyprA5g_Ol1Y"
})(App)