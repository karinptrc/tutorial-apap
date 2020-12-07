import React from "react";

import List from "./components/List";
import listMovies from "./movies.json";
import "./App.css";
import Toggle from 'react-toggle';
import EmptyState from "./components/EmptyState";

export default class App extends React.Component {
    state = {
        favItems: [],
        show : true,
        darkMode : false,
        theme : "light",
    };

    changeBG = () => {
        const {darkMode} = this.state;
        if (this.state.darkMode == false){
            this.setState({darkMode: true});
            this.setState({theme: "dark"});
        } else {
            this.setState({darkMode: false});
            this.setState({theme: "light"});
        }
    }

    handleToggle = () => {
        const {show} = this.state;
        this.setState({show : !show});
    }

    addToFavorites = (item) => {
        const newItems = [ ... this.state.favItems];
        const newItem = { ... item };

        const targetInd = newItems.findIndex((it) => it.id === newItem.id);

        if(targetInd < 0) newItems.push(newItem);
        // else newItems.splice(targetInd, 1);

        this.setState({favItems: newItems});
    }

    handleItemClick = (item) => {
        const newItems = [ ... this.state.favItems];
        const newItem = { ... item };

        const targetInd = newItems.findIndex((it) => it.id === newItem.id);

        if(targetInd < 0) newItems.push(newItem);
        else newItems.splice(targetInd, 1);

        this.setState({favItems: newItems});
    };

    deleteFav = () => {
        this.setState({favItems:[]});
    }

  render() {
      const {favItems} = this.state;
    return(
        <div className={this.state.theme}>
          <h1 className="text-center mt-3 mb-0"> Favorites Movie App</h1>
          <p className="text-center text-secondary text-sm font-italic">
              (This is a <strong>class-based</strong> application)
          </p>
            <div className="row justify-content-md-center">
            <label>
                <Toggle
                    defaultChecked={this.state.show}
                    icons={false}
                    onChange={this.handleToggle} />
                <span>Show Favorites</span>
            </label>
                <label>
                    <Toggle
                        defaultChecked={this.state.darkMode}
                        icons={false}
                        onChange={this.changeBG} />
                    <span>Show Favorites</span>
                </label>

            </div>
            <div className="container pt-3">
                <div className="row">
                    <div className="col-sm">
                        <List
                            title="List Movies"
                            items={listMovies}
                            onItemClick={this.addToFavorites}
                        />
                    </div>
                    {this.state.show ?
                        <div className="col-sm">
                            {!this.state.favItems.length ? <EmptyState/> :
                                <div>
                                <input
                                    className="float-right"
                                    type={this.state.favItems.length == 0 ? 'hidden':'button'}
                                    onClick={this.deleteFav}
                                    value="Delete"
                                />
                                <List
                                    title = "My Favorite"
                                    items = {favItems}
                                    onItemClick = {this.handleItemClick}
                                />
                                </div>}
                        </div>
                        : null}
                </div>
            </div>
        </div>
    );
  }
}