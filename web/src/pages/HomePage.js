import React from 'react';

import { Container, Row, Col, Image, Nav, ListGroup, Button, ButtonToolbar, Navbar } from 'react-bootstrap';
import {LinkContainer} from 'react-router-bootstrap'


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
                

                <Container fluid>
                    <Row>
                        <Col>
                            <LinkContainer exact to="/addimage">
                                <Nav.Link>Raporteaza</Nav.Link>
                            </LinkContainer>
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

