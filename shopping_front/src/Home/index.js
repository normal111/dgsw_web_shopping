import React, {Component} from 'react';
import SimpleProduct from "../Product/SimpleProduct";

import './Home.scss';

class Home extends Component {
    render() {
        return (
            <div>
                <div className='home-main'>
                    메인 베너
                </div>

                <div className='home-left-aside'>
                    <SimpleProduct product_id={1}/>
                    <SimpleProduct product_id={1}/>
                    <SimpleProduct product_id={1}/>
                    <SimpleProduct product_id={1}/>
                </div>

                <div className='home-section'>
                    <SimpleProduct product_id={1}/>
                    <SimpleProduct product_id={1}/>
                    <SimpleProduct product_id={1}/>
                    <SimpleProduct product_id={1}/>
                    <SimpleProduct product_id={1}/>
                    <SimpleProduct product_id={1}/>
                </div>

                <div className='home-right-aside'>
                    <SimpleProduct product_id={1}/>
                    <SimpleProduct product_id={1}/>
                    <SimpleProduct product_id={1}/>
                    <SimpleProduct product_id={1}/>
                    <SimpleProduct product_id={1}/>
                    <SimpleProduct product_id={1}/>
                </div>
            </div>
        );
    }

}

export default Home;