import React, {Component} from 'react';
import {inject, observer} from "mobx-react";
import {Redirect} from 'react-router-dom';

import './Product.scss'

import Comment from '../Comment';

@inject('stores')
@observer
class Product extends Component {
    state = {
        gotoCart: false,
        product_id: null,
        user_id: null,
        count: 1,
    };

    async componentDidMount() {
        if (this.props.match.params.product_id && this.props.match.params.product_id !== "") {
            let product_id = this.props.match.params.product_id;
            await this.props.stores.ProductStore.setProduct(product_id);
            this.setState({
                product_id: product_id
            });
        }
    }

    render() {
        if (this.state.gotoCart) {
            return <Redirect to='/cart'/>;
        }

        let p = this.props.stores.ProductStore.current_product;

        if (p === null)
            return <div/>;

        let imageSrc = `http://localhost:8080/download/product/${p.id}`;
        
        return (
            <div className='product-Container'>

                <div className='product-top'>
                    <div className='product-left'>
                        <div className='product-name'>{p.name}</div>
                        <img className='product-image' src={imageSrc} alt="제품이미지"/>
                    </div>

                    <div className='product-right'>
                        <div>제조사 : {p.company}</div>
                        <div>마일리지 : {p.mileage}원</div>
                        주문수량 : <input className='product-count' type="number" onChange={this.updateCount}
                                      defaultValue={1}/>
                        <div>가격 : {p.price}원</div>
                        <div>-----------------------</div>
                        <button onClick={this.goCart}>장바구니</button>
                    </div>
                </div>
                <br/>
                <div className='product-bottom'>
                    <div className='product-detail'>
                        <div className='product-text'>제품상세정보</div>
                        <pre>{p.detail}</pre>
                    </div>
                    <br/>
                    <div className='product-pur'>
                        <div className='product-text'>구매정보</div>
                        <pre>{p.pur_info}</pre>
                    </div>
                    <br/>
                    <div className='product-comment'>
                        <div className='product-text'>상품평</div>
                        <br/>
                        <Comment product_id={p.id}/>
                    </div>
                </div>

            </div>
        );
    }

    goCart = async () => {
        if (this.props.stores.UserStore.current_user !== null) {
            this.state.user_id = this.props.stores.UserStore.current_user.id;
        }
        if (this.state.user_id === null) {
            alert("로그인 해주세요");
        } else {
            await this.props.stores.CartStore.addCart(this.state);
            alert("장바구니에 담겼습니다");
            this.setState({
                gotoCart: true
            });
        }
    };

    updateCount = event => {
        this.setState({
            count: event.target.value
        });
    };

}

export default Product;