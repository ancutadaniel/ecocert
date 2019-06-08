import React from 'react';
import FooterMenu from './../shared/footerMenu';
import { Container, Row, Col, Image } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { google, appstore} from './../images/index';
import '../Footer.css';
// import axios from 'axios';



class Footer extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            category: [],
        };
        this.apiUrl = "http://localhost:3004/menu";

    }

    // async componentDidMount() {
    //     const resp = await axios.get(this.apiUrl);
    //     this.setState({ category: resp.data });
    //     console.log(resp.data);
    // }


    render() {
        return (
            <>
            <Container className="footer_wrapper" fluid>
                <Row className="footer_first_row">
                    <FooterMenu>7</FooterMenu>
                </Row>
                <Row className="social_row">
                    <Col className="social">
                        <Link to='/'>
                            <span><FontAwesomeIcon icon={['fab', 'google']} /></span>
                        </Link>
                        <Link to="/">
                             <span><FontAwesomeIcon icon={['fab', 'facebook']} /></span>
                        </Link>
                        <Link to="/">
                            <Image className="social_app" src={appstore}></Image>
                        </Link>
                        <Link to="/">
                            <Image className="social_google" src={google}></Image>
                        </Link>
                    </Col>
                </Row>
            </Container>
            </>
        )
    }
}
export default Footer;
