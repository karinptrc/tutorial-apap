import React, { useState } from "react";
import List from "./components/List";
import listMovies from "./movies.json";
import "./App.css";
import EmptyState from "./components/EmptyState";
import Toggle from "react-toggle";

/**
 * Building React component using functional programming paradigm
 */
function App() {
// Btw, this is hooks. useState function returns an array
// contains the state and a function to set the state -> [state, setState].
// What you see below is array destruction.
// Let say you have an array const arr = ["aaa", "bbb"], to access the item
// we can use index arr[0] OR destruct it like below
// const [varName, index1] = arr, variable varName is guaranteed to get the value of index 0 OR "aaa"
// here is the illustration for this situation
// below is the return value of useState
// [favItems, setFavItems] = [state, setState]
    const [favItems, setFavItems] = useState(() => []);
    const [show, setShow] = useState(() => true)

    function handleToggle() {
        setShow(!show);
    }

    function addToFavorites(item) {
        const newItems = [ ... favItems];
        const newItem = { ... item };

        const targetInd = newItems.findIndex((it) => it.id === newItem.id);

        if(targetInd < 0) newItems.push(newItem);
        // else newItems.splice(targetInd, 1);

        setFavItems(newItems);
    }

    function handleItemClick(item) {
        // immutability
        const newItems = [...favItems];
        const newItem = { ...item };
        // Find index of item with id
        const targetInd = newItems.findIndex(it => it.id === newItem.id);
        if (targetInd < 0) newItems.push(newItem);
        else newItems.splice(targetInd, 1); // delete 1 item at index targetInd
        // trigger to set a new state
        setFavItems(newItems);
    }

    function deleteFav() {
        setFavItems([]);
    }

    return (
        <div className="container-fluid">
            <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
            <p className="text-center text-secondary text-sm font-italic">
                (This is a <strong>function-based</strong> application)
            </p>
            <div className="row justify-content-md-center">
                <label>
                    <Toggle
                        defaultChecked={show}
                        icons={false}
                        onChange={handleToggle} />
                    <span>Show Favorites</span>
                </label>
            </div>
            <div className="container pt-3">
                <div className="row">
                    <div className="col-sm">
                        <List
                            title="List Movies"
                            items={listMovies}
                            onItemClick={addToFavorites}
                        />
                    </div>
                    {show ?
                        <div className="col-sm">
                            {favItems.length == 0 ? <EmptyState/> :
                                <div>
                                    <input
                                        className="float-right"
                                        type={favItems.length == 0 ? 'hidden':'button'}
                                        onClick={deleteFav}
                                        value="Delete"
                                    />
                                    <List
                                        title = "My Favorite"
                                        items = {favItems}
                                        onItemClick = {handleItemClick}
                                    />
                                </div>}
                        </div>
                        : null}
                    {/*<div className="col-sm">*/}
                    {/*    <input*/}
                    {/*        className="float-right"*/}
                    {/*        type={favItems.length == 0 ? 'hidden':'button'}*/}
                    {/*        onClick={deleteFav}*/}
                    {/*        value="Delete"*/}
                    {/*    />*/}
                    {/*    <List*/}
                    {/*        title="My Favorites"*/}
                    {/*        items={favItems}*/}
                    {/*        onItemClick={handleItemClick}*/}
                    {/*    />*/}
                    {/*</div>*/}
                </div>
            </div>
        </div>
    );
}
export default App;