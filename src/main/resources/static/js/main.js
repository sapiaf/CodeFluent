let flashcards = [];
let currentCardIndex = 0;

document.addEventListener('DOMContentLoaded', async function () {
    const deckId = document.getElementById('deckId').value;
    flashcards = await getFlashcards(deckId);

    if (flashcards.length > 0) {
        showFrontOfCard(currentCardIndex, flashcards);

        document.getElementById('buttons').addEventListener('click', function (event) {
            if (event.target.id === 'showAnswer') {
                showBackOfCard(currentCardIndex, flashcards);
            } else if (event.target.classList.contains('difficulty')) {

                const difficulty = event.target.dataset.difficulty;


                currentCardIndex++;
                if (currentCardIndex < flashcards.length) {
                    showFrontOfCard(currentCardIndex, flashcards);
                } else {
                   document.querySelector('.card-body').innerHTML = `<p class="card-text">Le flashcard sono finite!</p>`
                }
            }
        });
    }
});

function showFrontOfCard(index, flashcards) {
    document.getElementById('frontCard').textContent = flashcards[index].front;
    document.getElementById('backCard').classList.add('hidden');
    document.getElementById('buttons').innerHTML = `
        <button class="btn btn-primary btn-lg" id="showAnswer">Show Answer</button>
    `;
}

function showBackOfCard(index, flashcards) {
    document.getElementById('backCard').innerHTML = flashcards[index].back;
    document.getElementById('backCard').classList.remove('hidden');
    document.getElementById('buttons').innerHTML = `
        <button class="btn btn-primary btn-lg difficulty me-3" data-difficulty="hard">Hard</button>
        <button class="btn btn-primary btn-lg difficulty me-3" data-difficulty="medium">Medium</button>
        <button class="btn btn-primary btn-lg difficulty" data-difficulty="easy">Easy</button>
    `;
}




async function getFlashcards(deckId) {
    try {
        const response = await fetch(`/api/v1/decks/${deckId}`);
        if (!response.ok) {
            throw new Error('Error fetching flashcards');
        }

        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Error fetching flashcards:', error);
        return [];
    }
}
