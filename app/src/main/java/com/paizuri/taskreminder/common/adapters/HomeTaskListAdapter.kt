package com.paizuri.taskreminder.common.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paizuri.taskreminder.common.entities.Task
import com.paizuri.taskreminder.databinding.ItemTaskBinding
import com.paizuri.taskreminder.common.extensions.setOnClick

class HomeTaskListAdapter : RecyclerView.Adapter<HomeTaskListAdapter.TaskViewHolder>() {

    private lateinit var taskList: MutableList<Task>
    private lateinit var layoutInflater: LayoutInflater
    private lateinit var taskClickListener: TaskClickListener

    fun updateDataset(taskList: MutableList<Task>) {
        this.taskList = taskList
    }

    fun removeTaskFromDataset(task: Task, itemPosition: Int) {
        taskList.remove(task)
        notifyItemRemoved(itemPosition)
    }

    fun setItemClickListener(taskClickListener: TaskClickListener) {
        this.taskClickListener = taskClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        if (::layoutInflater.isInitialized.not()) {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        return TaskViewHolder(ItemTaskBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(taskList[position])
    }

    override fun getItemCount(): Int = taskList.size

    inner class TaskViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(task: Task) {
            binding.tvTaskTitle.text = task.taskTitle
            binding.tvTaskDescription.text = task.taskDescription
            binding.root.setOnClick {
                taskClickListener.onTaskClicked(task)
            }
            binding.ivDeleteTask.setOnClick {
                taskClickListener.onTaskChecked(task, adapterPosition)
            }
        }
    }

    interface TaskClickListener {
        fun onTaskClicked(task: Task)
        fun onTaskChecked(task: Task, taskPosition: Int)
    }
}