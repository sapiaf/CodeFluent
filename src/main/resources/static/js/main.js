const showAnswer = document.getElementById('showAnswer');
const buttons = document.getElementById('buttons');

showAnswer.addEventListener('click', showButtons)

function showButtons() {
  showAnswer.style.display = 'none'
  buttons.innerHTML = `
  <div class="d-flex justify-content-center">
                    <div>
                        <div class="text-center">&lt;10m</div>
                        <button class="btn btn-primary btn-lg m-1 btn-difficulty">
                            Again
                        </button>
                    </div>
                    <div>
                        <div class="text-center">&lt;15m</div>
                        <button class="btn btn-primary btn-lg m-1 btn-difficulty">
                            Hard
                        </button>
                    </div>
                    <div>
                        <div class="text-center">1d</div>
                        <button class="btn btn-primary btn-lg m-1 btn-difficulty" autofocus="">
                            Good
                        </button>
                    </div>
                    <div>
                        <div class="text-center">2d</div>
                        <button class="btn btn-primary btn-lg m-1 btn-difficulty">
                            Easy
                        </button>
                    </div>
                </div>
  `
  document.getElementById('backCard').parentNode.style.display = 'block';
}

let flashcards = [];
let currentCardIndex = 0;

function getFlashcards() {
  fetch('http://localhost:8080/api/v1/flashcards')
    .then(res => res.json())
    .then(data => {
      flashcards = data;
      displayCard();
    })
    .catch(error => console.error('Si è verificato un errore:', error));
}

function displayCard() {
  const currentCard = flashcards[currentCardIndex];
  document.getElementById('frontCard').innerHTML = currentCard.front;
  document.getElementById('backCard').innerHTML = currentCard.back;
}

function onDifficultyClick(difficultyIndex) {
  flashcards.splice(currentCardIndex, 1);

  if (flashcards.length > 0) {
    currentCardIndex = currentCardIndex % flashcards.length;
    displayCard();
  } else {
    console.log('Hai completato tutte le flashcard!');
  }
}

document.getElementById('buttons').addEventListener('click', function(event) {
  if (event.target.classList.contains('btn-difficulty')) {
    const difficultyIndex = Array.from(event.target.parentNode.parentNode.children).indexOf(event.target.parentNode);
    onDifficultyClick(difficultyIndex);
  }
});

window.onload = function() {
  getFlashcards();
};
