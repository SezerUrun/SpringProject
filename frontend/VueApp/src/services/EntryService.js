export async function getAllEntries() {
    const response = await fetch('/api/entries');
    return await response.json();
}

export async function createEntry(data) {
    const response = await fetch(`/api/entry`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data)
    })
    return await response.json();
}

export async function removeEntry(id) {
    const response = await fetch(`/api/entry/remove`, {
        method: 'DELETE',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(id)
    })
    return await response.json();
}

export async function removeAllEntries() {
    const response = await fetch('/api/entries/remove');
    return await response.json();
}
