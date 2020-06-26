SinglyLinkedListNode* reverse(SinglyLinkedListNode* head) {
    if (head == nullptr) {
        return nullptr;
    }

    SinglyLinkedListNode* prev = nullptr; 

    while (head != nullptr) {
        SinglyLinkedListNode* next = head->next;

        head->next = prev;

        prev = head;

        head = next;
    }

    return prev;
}