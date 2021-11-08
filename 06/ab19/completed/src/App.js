import React from 'react';
import { Container, Button } from 'reactstrap';

class App extends React.Component {
  constructor() {
    super();
    this.state = {
      counter: 0
    }
    this.increment = this.increment.bind(this);
    this.reset = this.reset.bind(this);
  }
  increment() {
      this.setState((state) => ({
        counter: state.counter + 1
      }))
  }
  reset() {
      this.setState(() => ({
          counter: 0
      }))
  }
  render() {
    return (
        <Container fluid>
            <div className="p-5 mb-4 bg-light rounded-3 border">
                <h1>{this.state.counter}</h1>
            </div>
            <Button color="primary" onClick={this.increment}>INCR</Button>&nbsp;
            <Button color="secondary" onClick={this.reset}>REFRESH</Button>
        </Container>
    )
  }
}

export default App;