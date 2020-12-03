import React from "react";

import List from "./components/List";
import listMovies from "./movies.json";
import "./App.css";

export default class App extends React.Component {
    state = {
        favItems: [],
    };

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
        this.setState(this.state.favItems.clear);
    }

  render() {
      const {favItems} = this.state;
    return(
        <div className="container-fluid">
          <h1 className="text-center mt-3 mb-0"> Favorites Movie App</h1>
          <p className="text-center text-secondary text-sm font-italic">
              (This is a <strong>class-based</strong> application)
          </p>
            <div className="container pt-3">
                <div className="row">
                    <div className="col-sm">
                        <List
                            title="List Movies"
                            items={listMovies}
                            onItemClick={this.addToFavorites}
                        />
                    </div>
                    <div className="col-sm">
                        <input
                            type={this.state.favItems.size > 0 ? 'button':'hidden'}
                            onClick={this.deleteFav}
                            value="Delete"
                        />
                        <List
                            title="My Favorites"
                            items={favItems}
                            onItemClick={this.handleItemClick}
                        />
                    </div>
                </div>
            </div>
        </div>
    );
  }
}