import React from "react";
import { Container, Button } from "reactstrap";

class App extends React.Component {
  constructor() {
    super();
    this.state = {
      counter: 0,
    };
    // this.increment = this.increment.bind(this);
    // this.reset = this.reset.bind(this);
  }
  componentDidMount() {
    this.timer = setInterval(this.increment, 1000);
  }
  componentWillUnmount() {
    clearInterval(this.timer);
  }
//   increment() {
//     this.setState({ counter: this.state.counter + 1 });
//   };
//   reset() {
//     this.setState({ counter: 0 });
//   };
  // Use arrow function to bind 'this' to function 'increment'
  increment = () => {
      this.setState((state) => ({
          counter: state.counter + 1
      }))
  };
  reset = () => {
    this.setState({ counter: 0 });
  };
  render() {
    return (
        <Container fluid>
            <div className="p-5 mb-4 bg-light rounded-3 border">
                <h1>{this.state.counter}</h1>
            </div>
            <Button color="secondary" onClick={this.reset}>REFRESH</Button>
        </Container>
    );
  }
}

export default App;
