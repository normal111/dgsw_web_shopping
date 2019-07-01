import React, {Component} from 'react';
import ProductItem from "../Product/ProductItem";

import './Home.scss';
import Main from "./Main"
class Home extends Component {
    render() {
        return (
            <div>
                <div className='home-main'>
                    <Main product_id={1}/>
                </div>

                <div className='home-event'>
                    <div className='home-event-text'>Event</div>
                    <br/>
                    <div className='home-items'>
                        <ProductItem product_id={2}/>
                        <ProductItem product_id={4}/>
                        <ProductItem product_id={6}/>
                    </div>
                </div>
                <br/>

                <div className='home-event'>
                    <div className='home-event-text'>Sales</div>
                    <br/>
                    <div className='home-items'>
                        <ProductItem product_id={3}/>
                        <ProductItem product_id={5}/>
                        <ProductItem product_id={7}/>
                    </div>
                </div>
            </div>
        );
    }

}

export default Home;