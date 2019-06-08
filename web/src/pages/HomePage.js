import React  from 'react';

import { Container, Row, Col, Image, ListGroup, Button, ButtonToolbar, Navbar } from 'react-bootstrap';
import { Map, Marker, GoogleApiWrapper } from 'google-maps-react';


class HomePage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            welcome: "Welcome To our Food App Menu",
            posts: []
        };
    }
    render() {
        return (
            <Row>
                
                    
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
                    </Col> */}
                    {/* <Col xs={12} md={6} className="map" >
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
                    </Col> */}
              </Row>
        );
    }
}
export default HomePage;