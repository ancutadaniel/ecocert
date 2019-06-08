import React from 'react';
import { Navbar, Nav, Button, ButtonToolbar } from 'react-bootstrap';
import { LinkContainer } from 'react-router-bootstrap';
// import ModalLogin from '../views/pages/ModalLogin';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

class MainMenu extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            modalShow: false
        };
    }
    render() {
        // let modalClose = () => this.setState({ modalShow: false });
        return (
            <Navbar variant="light" expand="sm">
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="ml-auto">                    
                        <LinkContainer exact to="/">
                            <Nav.Link><span><FontAwesomeIcon  icon={['fas', 'book-open']} size={'lg'} /></span> Home</Nav.Link>
                        </LinkContainer>
                        <LinkContainer exact to="/formular">
                            <Nav.Link><span className="book"><FontAwesomeIcon icon={['fas', 'book-open']} size={'lg'}/></span>Formular</Nav.Link>
                        </LinkContainer>
                        {/*<LinkContainer to="/contact">
                            <Nav.Link><span className="book"><FontAwesomeIcon icon={['fas', 'edit']} size={'lg'}/></span>Contact</Nav.Link>
                        </LinkContainer>
                        <LinkContainer to="/signup">
                            <Nav.Link>Sign Up<span className="sign_fa"><FontAwesomeIcon icon={['fas', 'sign-in-alt']} size={'lg'}/></span></Nav.Link>
                        </LinkContainer> */}
                    </Nav>
                    <ButtonToolbar>
                            <Button className="btn_mob" variant="outline-success" onClick={() => this.setState({ modalShow: true })}> Log In </Button>
                            {/* <ModalLogin show={this.state.modalShow} onHide={modalClose} /> */}
                    </ButtonToolbar>

                </Navbar.Collapse>
            </Navbar>
        );
    }
}


export default MainMenu;
