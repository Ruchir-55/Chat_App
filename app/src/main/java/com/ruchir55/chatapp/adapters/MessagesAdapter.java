package com.ruchir55.chatapp.adapters;

import android.location.OnNmeaMessageListener;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ruchir55.chatapp.databinding.ReceivedMessagesItemBinding;
import com.ruchir55.chatapp.databinding.SentMessagesItemBinding;
import com.ruchir55.chatapp.models.MessagesModel;
import com.ruchir55.chatapp.views.MessagingActivity;

import java.util.ArrayList;

public class MessagesAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_SENT_MESSAGE = 1;
    private static final int VIEW_TYPE_RECEIVED_MESSAGE = 2;

    ArrayList<MessagesModel> messagesList;
    String currentUserId;


    public MessagesAdapter(ArrayList<MessagesModel> messagesList, String currentUserId) {
        this.messagesList = messagesList;
        this.currentUserId = currentUserId;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if(viewType == VIEW_TYPE_SENT_MESSAGE) {
            SentMessagesItemBinding sentMessagesItemBinding = SentMessagesItemBinding.inflate(inflater, parent, false);
            viewHolder = new SentMessagesViewHolder(sentMessagesItemBinding);
        } else if (viewType == VIEW_TYPE_RECEIVED_MESSAGE) {
            ReceivedMessagesItemBinding receivedMessagesItemBinding = ReceivedMessagesItemBinding.inflate(inflater, parent, false);
            viewHolder = new ReceivedMessagesViewHolder(receivedMessagesItemBinding);
        }
        else {
            return null;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MessagesModel message = messagesList.get(position);
        if(holder instanceof SentMessagesViewHolder) {
            ((SentMessagesViewHolder) holder).sentMessagesItemBinding.textViewMessageSent.setText(message.getMessage());
        } else if (holder instanceof ReceivedMessagesViewHolder) {
            ((ReceivedMessagesViewHolder) holder).receivedMessagesItemBinding.textViewMessageReceived.setText(message.getMessage());


        }

    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }

    public static class SentMessagesViewHolder extends RecyclerView.ViewHolder {

        SentMessagesItemBinding sentMessagesItemBinding;

        public SentMessagesViewHolder(@NonNull SentMessagesItemBinding sentMessagesItemBinding) {
            super(sentMessagesItemBinding.getRoot());
            this.sentMessagesItemBinding = sentMessagesItemBinding;
        }
    }

    public static class ReceivedMessagesViewHolder extends RecyclerView.ViewHolder {

        ReceivedMessagesItemBinding receivedMessagesItemBinding;

        public ReceivedMessagesViewHolder(@NonNull ReceivedMessagesItemBinding receivedMessagesItemBinding) {
            super(receivedMessagesItemBinding.getRoot());
            this.receivedMessagesItemBinding = receivedMessagesItemBinding;
        }
    }

    @Override
    public int getItemViewType(int position) {

        if(messagesList.get(position).getSenderid().equals(currentUserId)) {
            return VIEW_TYPE_SENT_MESSAGE;
        }
        else {
            return VIEW_TYPE_RECEIVED_MESSAGE;
        }
    }
}
