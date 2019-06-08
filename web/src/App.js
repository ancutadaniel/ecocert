import React from 'react';
import './App.css';
import { FilePond, registerPlugin } from 'react-filepond';
import 'filepond/dist/filepond.min.css';

import FilePondPluginImagePreview from 'filepond-plugin-image-preview';
import 'filepond-plugin-image-preview/dist/filepond-plugin-image-preview.min.css';

import FilePondPluginFileValidateType from 'filepond-plugin-file-validate-type';

import "bootstrap/dist/css/bootstrap.min.css";

import { BrowserRouter, Route} from 'react-router-dom';
import { Container, Row, Col, Image, ListGroup, Navbar, ButtonToolbar, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { Map, Marker, GoogleApiWrapper } from 'google-maps-react';
import "bootstrap/dist/css/bootstrap.min.css";
// import { Formular } from './pages/Formular';

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
                    <FilePond ref={ref => this.pond = ref} allowMultiple={true} server={this.state.server} acceptedFileTypes={this.state.acceptedFileTypes}
                              required={this.state.required}
                              onprocessfiles={(fileItems) => {
                                  this.setState({
                                      nextDisabled: false
                                  });
                              }}
                    />
                    <Button variant="success" disabled={this.state.nextDisabled} onClick={this.handleClick}>Next</Button>
                    <Row>
                        <Navbar bg="dark" variant="dark">
                            <Navbar.Brand href="#home">
                                <Image
                                    alt=""
                                    src="/logo.svg"
                                    width="30"
                                    height="30"
                                    className="d-inline-block align-top"
                                />

                            </Navbar.Brand>
                        </Navbar>
                    </Row>
                    <Row>
                        <Container fluid>
                            <Col>
                                {/* <Route exact path="/contact" component={ Formular } > */}
                                <h1>Raporteaza</h1>
                                <p>This is a modified jumbotron that occupies the entire horizontal space of
                                    its parent.</p>
                                {/* </Route > */}
                            </Col>
                        </Container>
                        <Container fluid>
                            <Col>
                                <h1>Gunoaie in apropiere</h1>
                                <Map className="map_google" google={this.props.google}
                                     initialCenter={{
                                         lat: 45.6525767,
                                         lng: 25.5264224
                                     }}
                                     zoom={10}
                                >
                                    <Marker onClick={this.onMarkerClick} name={'Current location'} />
                                </Map>
                            </Col>
                        </Container>
                        <Container fluid>
                            <Col>
                                <h1>Puncte de reciclare</h1>
                                <ButtonToolbar>
                                    <Button variant="primary">Primary</Button>
                                    <Button variant="success">Success</Button>
                                </ButtonToolbar>
                            </Col>
                        </Container>
                    </Row>
                    {/* <Row className="map_row">
                  <Col xs={12} md={6} className="homepage_localization">
                      <h3 className="homepage_title">Discover, order, and track in the app.</h3>
                      <p className="hompage_paragraph">We are a start-up on-demand network in the industry and  you can explore your city, find its hidden hotspots, and watch as we bring your new favorites right to your door. </p>
                  </Col>
                  <Col xs={12} md={6} className="map" >
                      <Col className="homepage_google_map">
                          <Map className="map_google" google={this.props.google}
                              initialCenter={{
                                      lat: 45.6525767,
                                      lng: 25.5264224
                                  }}
                              zoom={10}
                          >
                          <Marker onClick={this.onMarkerClick} name={'Current location'} />
                      </Map>
                      </Col>
                  </Col>
              </Row>*/}
                </Container>
            </BrowserRouter>
        );
    }
}

export default GoogleApiWrapper({
  apiKey: "AIzaSyA8IRQEYZiMYyOsk5SNapLmyprA5g_Ol1Y"
})(App)