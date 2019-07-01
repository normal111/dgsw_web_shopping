import React, {Component} from 'react';
import {inject, observer} from "mobx-react";

import './Comment.scss'

@inject('stores')
@observer
class Comment extends Component {
    state = {
        comments: null,
        product_id: null,
        user_id: null,
        content: null
    };

    async componentDidMount() {
        let product_id = this.props.product_id;
        this.state.product_id = product_id;
        await this.props.stores.CommentStore.getComment(product_id);
        await this.setState({
            comments: this.props.stores.CommentStore.current_comment
        });
    }

    render() {
        if (this.state.comments === null)
            return <div/>;

        return (

            <div>
                <div>
                    <input type="text" id='comment-text' onChange={this.updateComment}/>
                    <button onClick={this.insertComment}>상품평쓰기</button>
                </div>
                <br/>
                {this.state.comments.map(comment => {
                    return (
                        <div key={comment.id}>
                            <div className='comment-container'>
                                <div className='comment-user_id'>{comment.user_id}</div>
                                <div className='comment-content'>{comment.content}</div>
                                <div className='comment-created'>{comment.created}</div>
                            </div>
                            <br/>
                        </div>)
                })}
            </div>
        );
    }

    insertComment = async () => {
        if (this.props.stores.UserStore.current_user !== null) {
            this.state.user_id = this.props.stores.UserStore.current_user.id;
        }

        if (this.state.user_id == null) {
            alert("로그인 해주세요");
            return;
        }

        let result = await this.props.stores.CommentStore.insertComment(this.state);

        if (result === true) {
            alert("작성 성공");
            let commentText = document.getElementById('comment-text');
            commentText.value = "";
            this.refreshList();
        } else {
            alert("작성 실패");
        }
    };

    refreshList = async () => {
        await this.props.stores.CommentStore.getComment(this.state.product_id);
        this.setState({
            comments: this.props.stores.CommentStore.current_comment,
            content: null
        });
    };

    updateComment = event => {
        this.setState({
            content: event.target.value
        });
    };
}

export default Comment;