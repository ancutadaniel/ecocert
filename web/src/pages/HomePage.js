import React from 'react';

import { Container, Row, Col, Image, Nav, ListGroup, Button, ButtonToolbar, Navbar } from 'react-bootstrap';
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
            <Container>
                <Row className="text-center">
                    <Navbar bg="primary" variant="dark" id="navigation">
                        <Navbar.Brand href="#home" className="logo">
                            <Image
                                src="./ecocert-logo.png"
                                width="auto"
                                height="auto"
                                className="d-inline-block align-top"
                            // alt="React Bootstrap logo"
                            />
                        </Navbar.Brand>
                        <Nav className="mr-auto ">
                            <Nav.Link href="#home">Gunoaie</Nav.Link>
                            <Nav.Link href="#features">Reciclare</Nav.Link>
                            <Nav.Link href="#pricing">Rescue</Nav.Link>
                            <Nav.Link href="#pricing">GDPR</Nav.Link>
                            <Nav.Link>
                                <Image />
                            </Nav.Link>
                        </Nav>
                    </Navbar>

                </Row >


                <Container fluid>
                    <Row>
                        <Col>
                            <h1>
                                Raporteaza
                </h1>
                            <p>

                            </p>
                            <button className="">
                                Raporteaza
              </button>
                        </Col>
                    </Row>
                </Container>

                <Container fluid>
                    <Row>
                        <Col>
                            <h1>Afiseaza gunoaie</h1>
                            <p></p>
                            <button>Afiseaza</button>
                        </Col>
                    </Row>
                </Container>

                <Container fluid>
                    <Row>
                        <Col>

                        </Col>
                    </Row>
                </Container>
            </Container>

        );
    }

}
export default HomePage

