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
            <Container className="home">
                

                <Container fluid className="raport">
                    <Row>
                        <Col>
                            <LinkContainer exact to="/addimage">
                               <Nav.Link  className="title"><h2>Raporteaza</h2> </Nav.Link>
                            </LinkContainer>
                        </Col>
                    </Row>
                </Container>

                <Container fluid  className="afis" >
                    <Row>
                        <Col>                            
                            <LinkContainer exact to="/pubela">
                               <Nav.Link  className="title"><h2>Afiseaza gunoaie</h2></Nav.Link>
                            </LinkContainer>                            
                        </Col>
                    </Row>
                </Container>

                <Container fluid className="last"> 
                    <Row>
                        <Col>                            
                            <LinkContainer exact to="/reciclare">
                               <Nav.Link  className="title"><h2>Puncte de reciclare</h2></Nav.Link>
                            </LinkContainer>
                        </Col>
                    </Row>
                </Container>
            </Container>

        );
    }

}
export default HomePage

