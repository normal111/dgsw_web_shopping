import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import {inject, observer} from "mobx-react";

import './CategoryBar.scss';

@inject('stores')
@observer
class CategoryBar extends Component {
    state = {
        category: []
    };

    async componentDidMount() {
        await this.props.stores.CategoryStore.getCategory();
        this.setState({
            category: this.props.stores.CategoryStore.current_category
        });
    }

    render() {
        return (
            <div>
                <ul className='category-bar'>
                    {
                        this.state.category.map(item => {
                                let link = `/category/${item.id}`;
                                return (<li className='category-item' key={item.id}><Link to={link}>{item.name}</Link></li>)
                            }
                        )
                    }
                </ul>
            </div>
        );
    }
}

export default CategoryBar;