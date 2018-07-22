# suggestion

This project uses Spring boot2, kotlin and reactive style of programing. This is a stateless project which creates certail statistics based on historical data.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Java install in the machine


### Installing

```
git clone https://github.com/cprasenj/suggestion.git

```
cd suggestion

```
./gradlew clean build

```
The application runs in port 3000 by default

```
Do a post call using command line or postman or anyother tool to http://localhost:3000/pairing/suggestion

```
with body as

[
	{
		"pair1": "a1",
		"pair2": "b1",
		"days": 2
	},
	{
		"pair1": "a1",
		"pair2": "b2",
		"days": 3
	},
	{
		"pair1": "a2",
		"pair2": "b2",
		"days": 1
	},
	{
		"pair1": "a2",
		"pair2": "b1",
		"days": 7
	}
]
```

should give you the following response

[
  {
    "first": "a1",
    "second": "b1"
  },
  {
    "first": "b1",
    "second": "a1"
  },
  {
    "first": "b2",
    "second": "a2"
  },
  {
    "first": "a2",
    "second": "b2"
  }
]
```

## Authors

* **Prasenjit Chakraborty** - *Initial work* - [cprasenj](https://github.com/cprasenj)

See also the list of [contributors](https://github.com/cprasenj/suggestion/graphs/contributors) who participated in this project.

