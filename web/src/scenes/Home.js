import React from 'react';
import { Container, Row, Col, Nav,} from 'react-bootstrap';
import {LinkContainer} from 'react-router-bootstrap';


class Home extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            welcome: "Formular",
            posts: []
        };
    }

    render() {
        return (
            <Container className="home">
                <Container fluid className="first">
                    <Row>
                        <Col>
                            <LinkContainer exact to="/uploadimage">
                                <Nav.Link  className="title"><h2>Upload Image</h2> </Nav.Link>
                            </LinkContainer>
                        </Col>
                    </Row>
                </Container>
                <Container fluid  className="second" >
                    <Row>
                        <Col>
                            <LinkContainer exact to="/form">
                                <Nav.Link  className="title"><h2>{this.state.welcome}</h2></Nav.Link>
                            </LinkContainer>
                        </Col>
                    </Row>
                </Container>
                <Container fluid className="last">
                    <Row>
                        <Col>
                            <LinkContainer exact to="/map">
                                <Nav.Link  className="title"><h2>Map</h2></Nav.Link>
                            </LinkContainer>
                        </Col>
                    </Row>
                </Container>
            </Container>

        );
    }

}
export default Home;